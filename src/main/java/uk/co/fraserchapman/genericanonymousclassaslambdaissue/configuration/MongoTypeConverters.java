package uk.co.fraserchapman.genericanonymousclassaslambdaissue.configuration;

import org.bson.types.Decimal128;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class MongoTypeConverters {

    @Bean
    public MongoCustomConversions customConversions() {
//        This works:
//
//        final Converter<Decimal128, BigDecimal> decimal128ToBigDecimal = new Converter<Decimal128, BigDecimal>() {
//            @Override
//            public BigDecimal convert(final Decimal128 decimal128) {
//                return decimal128.bigDecimalValue();
//            }
//        };
//
//        final Converter<BigDecimal, Decimal128> bigDecimalToDecimal128 = new Converter<BigDecimal, Decimal128>() {
//            @Override
//            public Decimal128 convert(final BigDecimal value) {
//                return new Decimal128(value);
//            }
//        };

//        This doesn't:
        final Converter<Decimal128, BigDecimal> decimal128ToBigDecimal = decimal128 -> decimal128.bigDecimalValue();
        final Converter<BigDecimal, Decimal128> bigDecimalToDecimal128 = value -> new Decimal128(value);

        return MongoCustomConversions.create(configurer ->
                configurer.registerConverters(List.of(decimal128ToBigDecimal, bigDecimalToDecimal128))
        );
    }
}
