package productpacking2;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;
import productpacking2.config.kafka.KafkaProcessor;


@Entity
@Table(name="ProductPaking_table")
public class ProductPaking {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String productInfo;

    @PostPersist
    public void onPostPersist(){
        ProductPacked productPacked = new ProductPacked();
        BeanUtils.copyProperties(this, productPacked);
        productPacked.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }




}
