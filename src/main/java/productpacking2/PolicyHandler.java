package productpacking2;

import productpacking2.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPackingordered_ReqestProductPacking(@Payload Packingordered packingordered){

        if(packingordered.isMe()){
            System.out.println("##### listener ReqestProductPacking : " + packingordered.toJson());
        }
    }

}