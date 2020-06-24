package br.com.mastertech.ProducerConsPorta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AutorizaProducer {

    @Autowired
    private KafkaTemplate<String, Autoriza> producer;

    public void enviarAoKafka(Autoriza autoriza) {

        producer.send("spec2-nivio-pinheiro-1", autoriza);
    }

}
