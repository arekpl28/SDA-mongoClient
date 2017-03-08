package pl.sda.mongo;

import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PostsDAO dao = new PostsDAO();

//        Post post = new Post();
//        post.setAuthor("Jannn");
//        post.setContent("Cos nowego jak ");
//        post.setDate(new Date());
//        dao.insert(post);
//        System.out.println(post.toString());

        Post post1 = new Post();
        post1.setAuthor("Tadek");
        post1.setContent("Tadek1111");
        post1.setDate(new Date());

        dao.update(post1, new ObjectId("58c0600cdbca3b01b8db59e2"));


//        List<DBObject> dbObjects = dao.searchById(new ObjectId("58c050bedbca3b02a491bba0"));
//        System.out.println(dbObjects);

//        DBObject dbObject = dao.removeById(new ObjectId("58c03ca0d99ccb52fefe228d"));
//        System.out.println(dbObject);
    }
}
