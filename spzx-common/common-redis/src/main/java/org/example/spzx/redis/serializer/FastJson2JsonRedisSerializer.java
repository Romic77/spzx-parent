package org.example.spzx.redis.serializer;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.filter.Filter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class FastJson2JsonRedisSerializer<T> implements RedisSerializer<T> {
    static final Filter autoTypeFilter = JSONReader.autoTypeFilter(
            // 按需加上需要支持自动类型的类名前缀，范围越小越安全
            "org.springframework.security.core.authority.SimpleGrantedAuthority"
    );

    private Class<T> clazz;

    public FastJson2JsonRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        return JSON.toJSONBytes(t, JSONWriter.Feature.WriteClassName);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (null == bytes || bytes.length <= 0) {
            return null;
        }
        return JSON.parseObject(bytes, clazz, autoTypeFilter, JSONReader.Feature.SupportAutoType);
    }
}