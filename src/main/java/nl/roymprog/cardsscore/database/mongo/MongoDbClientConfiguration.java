package nl.roymprog.cardsscore.database.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
@Profile("prod")
class MongoDbClientConfiguration extends AbstractMongoConfiguration {

  @Autowired
  private MongoDbConfig mongoDbConfig;

  @Override
  protected String getDatabaseName() {
    return mongoDbConfig.getDatabase();
  }

  @Override
  public MongoClient mongoClient() {
    String uri = String.format("mongodb+srv://%s:%s@cluster0.pmtkg.mongodb.net/%s",
            mongoDbConfig.getUsername(),
            mongoDbConfig.getPassword(),
            mongoDbConfig.getHost(),
            mongoDbConfig.getDatabase());
    System.out.println(uri);
    MongoClientURI mongoClientURI = new MongoClientURI(uri, mongoDbConfig.getMongoClientOptionsBuilder());

    return new MongoClient(mongoClientURI);
  }
}