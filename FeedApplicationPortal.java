import java.util.*;

class User{
    String id;
    String name;
    String email;
    String pwd;

    User(String id, String name, String email, String pwd){
        this.id = id;
        this.id = name;
        this.email = email;
        this.pwd = pwd;
    }
}

class Admin{
    String id;
    String name;
    String email;
    String pwd;

    Admin(String id, String name, String email, String pwd){
        this.id = id;
        this.name = name;
        this.email = email;
        this.pwd = pwd;
    }
}

class Post{
    String post_id;
    String user_id;
    String content;
    List<Comment> comments;

    Post(String post_id, String user_id, String content){
        this.post_id = post_id;
        this.user_id = user_id;
        this.content = content;
        this.comments = new ArrayList<>();
    }
}

class Comment{
    String comment_id;
    String user_id;
    String comment;
}

class Story{
    String story_id;
    String user_id;
    String content;
    int duration;
    String createdAt;

    Story(String story_id, String user_id, String content, int duration, String createdAt){
        this.story_id = story_id;
        this.user_id = user_id;
        this.content = content;
        this.duration = duration;
        this.createdAt = createdAt;
    }
}

class FeedApplicationPortal{
    List<User> users;
    List<Admin> admins;
    List<Post> posts;
    List<Story> stories;

    FeedApplicationPortal(){
        this.users = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void addUser(User user){
        this.users.add(user);
    }

    // public void addAdmin(Admin admin){
    //     this.admins.add(admin);
    // }

    public Post createPost(){
        int len_post = this.posts.size();
        String id = String.valueOf(len_post + 1);
        String user_id = "1";
        String content = "Hello World, This is a Sample Post";
        Post post = new Post(id, user_id, content);
        return post;
    }

    public void addPost(Post post){
        this.posts.add(post);
    }

    public int displayPosts(){
        int len = this.posts.size();
        for(Post post : this.posts){
            String p = post.post_id + ". " + post.content;
            System.out.println(p);

            // System.out.println("Comments are:");
            // if(this.posts.comments.size() == 0){
            //     System.out.println("No comments");
            //     return 1;
            // }
            // for(Comment comment : this.posts.comments){
            //     System.out.println(comment);
            // }
            System.out.println("---------------------");
        }
        if(len == 0) return -1;
        return 1;
    }

    public void addComments(String post_id, String comment){
        Post comm_post = null;
        for(Post post : this.posts){
            if(post.post_id.equals(post_id)){
                comm_post = post;
            }
        }
        if(comm_post == null){
            System.out.println("No post available");
            return;
        }
        // List<Comment> comments = this.posts.comments;
        // System.out.println(comments.size());
        for(Comment comm : comm_post.comments){
            
            System.out.println(comm);
        }
        System.out.println("-----------");
    }

    // public Story addStory(){
    //     int len_story = this.stories.size();
    //     String id = String.valueOf(len_story + 1);
    //     String user_id = "1";
    //     String content = "Hello World, This is a Sample Story";
    //     String time = 
    // }

    public static void main(String[] args){
        FeedApplicationPortal portal = new FeedApplicationPortal();
        Scanner sc = new Scanner(System.in);

        // Admin admin = new Admin("1", "Guru", "guru@gmail.com", "hello");

        // portal.addAdmin(admin);

        User user1 = new User("1", "Mounish", "mounish@gmail.com", "123456");
        User user2 = new User("2", "Sathish", "sathish@gmail.com", "sathish");

        portal.addUser(user1);
        portal.addUser(user2);

        boolean showMenu = true;

        while(showMenu){
            System.out.println("1. Add Posts");
            System.out.println("2. Add Story");
            System.out.println("3. Add Comment to Posts");
            System.out.println("4. View Posts");
            System.out.println("5. Share Posts");
            System.out.println("0. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    Post post = portal.createPost();
                    portal.addPost(post);
                    break;
                
                // case 2:
                //     Story story = portal.addStory();

                case 3:
                    System.out.print("Enter post id: ");
                    String post_id = sc.nextLine();
                    System.out.println();
                    System.out.println("Enter the comments:");
                    String comment = sc.nextLine();
                    portal.addComments(post_id, comment);
                    break;

                case 4:
                    System.out.println("The available Posts are");
                    if(portal.displayPosts() == -1){
                        System.out.println("No available posts");
                    }
                    break;

                
                case 0:
                    System.out.println("Thank You for visiting our platform");
                    showMenu = false;

            }
        }
    }
}