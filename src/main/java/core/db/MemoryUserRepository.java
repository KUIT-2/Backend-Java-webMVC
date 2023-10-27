package core.db;

import jwp.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemoryUserRepository {
    private Map<String, User> users = new HashMap<>();
    private static MemoryUserRepository memoryUserRepository;

    private MemoryUserRepository() {
    }

    public static MemoryUserRepository getInstance() {
        if (memoryUserRepository == null) {
            memoryUserRepository = new MemoryUserRepository();
            return memoryUserRepository;
        }
        return memoryUserRepository;
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public User findUserById(String userId) {
        return users.get(userId);
    }

    public Collection<User> findAll() {
        return users.values();
    }

    public void changeUserInfo(User user) {
        if (users.get(user.getUserId()) != null) {
            users.put(user.getUserId(), user); //동일한 key에 대해 덮어쓰기(overwrite)를 지원.
            System.out.println("수정됨");
        }
    }
}
