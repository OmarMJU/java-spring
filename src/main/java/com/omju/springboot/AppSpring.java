package com.omju.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Qualifier;
import com.omju.springboot.component.DependencyComponent;
import com.omju.springboot.bean.MyBeanWithDependency;
import com.omju.springboot.repository.UserRepository;
import com.omju.springboot.repository.PostRepository;
import com.omju.springboot.bean.ConfigPropertiesBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.apache.logging.log4j.LogManager;
import com.omju.springboot.pojo.UserPojo;
import com.omju.springboot.entity.User;
import com.omju.springboot.entity.Post;
import org.apache.logging.log4j.Logger;
import com.omju.springboot.bean.MyBean;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AppSpring implements CommandLineRunner {
    private static final Logger LOGGER = LogManager.getLogger(AppSpring.class);
    private final MyBeanWithDependency myBeanWithDependency;
    private final ConfigPropertiesBean configPropertiesBean;
    private final DependencyComponent dependencyComponent;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final UserPojo userPojo;
    private final MyBean myBean;

    public AppSpring(
            @Qualifier("dependencyTwoComponentImpl") DependencyComponent dependencyComponent,
            MyBean myBean,
            MyBeanWithDependency myBeanWithDependency,
            ConfigPropertiesBean configPropertiesBean,
            UserPojo userPojo,
            UserRepository userRepository,
            PostRepository postRepository
    ) {
        this.configPropertiesBean = configPropertiesBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.dependencyComponent = dependencyComponent;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.userPojo = userPojo;
        this.myBean = myBean;
    }

    public static void main(String[] args) {
        LOGGER.info("Spring boot app... Start!!!");
        SpringApplication.run(AppSpring.class, args);
    }

    @Override
    public void run(String... args) {
        executions();
        saveUserInDataBase();
        getUserByEmailJPQL("peter@mail.com");
        getUsersByName("User");
    }

    private void executions() {
        dependencyComponent.greeting();
        myBean.print();
        myBean.displayName("Omar");
        myBeanWithDependency.printDependency(5);
        configPropertiesBean.functionConfig();
        LOGGER.info("The user {} has the email {} and ID {}", userPojo.getFullName(), userPojo.getEmail(), userPojo.getId());
    }

    private void saveUserInDataBase() {
        LOGGER.info("-------------------------------------------");
        LOGGER.info("-----> Insert Users into H2 DATABASE <-----");
        LOGGER.info("-------------------------------------------");

        User user = new User("John", "john@mail.com", LocalDate.of(2021, 3, 20));
        User user2 = new User("Mary", "mary@mail.com", LocalDate.of(1991, 2, 15));
        User user3 = new User("Peter", "peter@mail.com", LocalDate.of(1999, 11, 7));
        User user4 = new User("Magnus", "magnus@mail.com", LocalDate.of(2005, 12, 6));
        User user5 = new User("User5", "user5@mail.com", LocalDate.of(2005, 12, 6));
        User user6 = new User("User6", "user6@mail.com", LocalDate.of(2005, 12, 6));
        User user7 = new User("User7", "user7@mail.com", LocalDate.of(2005, 12, 6));
        User user8 = new User("User8", "user8@mail.com", LocalDate.of(2005, 12, 6));
        User user9 = new User("User9", "user9@mail.com", LocalDate.of(2005, 12, 6));
        User user10 = new User("User10", "user10@mail.com", LocalDate.of(2005, 12, 6));
        User user11 = new User("User11", "user11@mail.com", LocalDate.of(2005, 12, 6));
        User user12 = new User("User12", "user12@mail.com", LocalDate.of(2005, 12, 6));

        List<User> users = Arrays.asList(user, user2, user3, user4, user5, user7, user8, user9, user10, user11, user12);
        users.stream().forEach(userRepository::save);
//        savePostInDataBase(users);
    }

    private void  savePostInDataBase(List<User> users) {
        LOGGER.info("------------------------------------------");
        LOGGER.info("-----> Insert Post into H2 DATABASE <-----");
        LOGGER.info("------------------------------------------");

        List<Post> posts = new ArrayList<>();
        Post post = null;
        int i = 1;

        for (User user : users) {
            post = new Post("This is the post " + i, user);
            posts.add(post);
            i++;
        }

        posts.stream().forEach(postRepository::save);
    }

    private void getUserByEmailJPQL(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        LOGGER.info("The user find is {}", user.toString());
    }

    private void getUsersByName(String name) {
        LOGGER.info("The the users with the name {} are:", name);
        userRepository.findUsersByName(name).stream().forEach(LOGGER::info);
    }
}