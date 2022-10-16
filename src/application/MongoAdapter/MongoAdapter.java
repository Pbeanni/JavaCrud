package application.MongoAdapter;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import core.entities.Processo;
import core.interfaces.DataLogicInterface;


import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoAdapter implements DataLogicInterface {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private CodecProvider pojoCodecProvider;
    private CodecRegistry pojoCodecRegistry;
    private MongoCollection<Processo> collection;


    public MongoAdapter() {
            this.pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            this.pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
            this.mongoClient = MongoClients.create("mongodb+srv://root:root@personalprojects.ypczy5z.mongodb.net/?retryWrites=true&w=majority");
            this.database = this.mongoClient.getDatabase("JavaCrud").withCodecRegistry(pojoCodecRegistry);
            this.collection = database.getCollection("Processo", Processo.class);
    }

    @Override
    public void create(Processo novoProcesso) {
    collection.insertOne(novoProcesso);

    }

    @Override
    public Processo update(ObjectId _ID, Processo updatedProcesso) {
        collection.replaceOne(Filters.eq("_id",_ID),updatedProcesso);
        return updatedProcesso;
    }

    @Override
    public List<Processo> get() {
        List<Processo> processos = new ArrayList<>();
        collection.find().into(processos);
        return processos;
    }

    @Override
    public Processo get(ObjectId _ID) {
        return collection.find(Filters.eq("_id",_ID)).first();
    }

    @Override
    public Processo delete(ObjectId _ID) {
        return collection.findOneAndDelete(Filters.eq("_id",_ID));
    }
}
