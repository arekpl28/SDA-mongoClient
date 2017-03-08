package pl.sda.mongo;

import com.mongodb.*;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class PostsDAO {

    public WriteResult insert(Post post) {
        DBCollection posts = getDbCollection();

        BasicDBObject newPost = new BasicDBObject();
        newPost.put("author", post.getAuthor());
        newPost.put("content", post.getContent());
        newPost.put("date", post.getDate());

        WriteResult insert = posts.insert(newPost);
        return insert;
    }

    public List<DBObject> searchById(Object id) {
        DBCollection posts = getDbCollection();
        BasicDBObject query = new BasicDBObject();
        query.put("_id", id);

        DBCursor postCursor = posts.find(query);
        List<DBObject> result = new ArrayList<>();

        while (postCursor.hasNext()) {
            DBObject post = postCursor.next();
            result.add(post);

        }
        return result;
    }

    public DBObject removeById(Object id) {
        BasicDBObject query = new BasicDBObject();
        query.put("_id", id);

        DBCollection post = getDbCollection();

        DBObject andRemove = post.findAndRemove(query);
        return andRemove;
    }

    private DBCollection getDbCollection() {
        String databaseName = "SDATest";
        String collection = "posts";

        Mongo mongoClient = new Mongo("localhost", 27017);
        return mongoClient.getDB(databaseName).getCollection(collection);
    }

    public WriteResult update(Post post, ObjectId id) {
        DBCollection posts = getDbCollection();
        BasicDBObject query = new BasicDBObject();
        query.put("_id", id);

        BasicDBObject update = new BasicDBObject();
        update.put("author", post.getAuthor());
        update.put("content", post.getContent());
        update.put("date", post.getDate());

        WriteResult writeResult = posts.update(query, update);

        return writeResult;

    }
}
