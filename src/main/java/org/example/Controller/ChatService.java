package org.example.Controller;

import org.example.Interfaces.IChatService;
import org.example.Interfaces.IUserService;
import org.example.model.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatService extends UnicastRemoteObject implements IChatService {
    static Map<Integer, IUserService> onlineUsers = new HashMap<>();
    UserDao userDao;
    private User user;
    protected ChatService() throws RemoteException {
        try {
            userDao = new UserDaoImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getFriendList(User user) {
        return userDao.getFriendList(user);
    }

    @Override
    public void changeStatus(UserStatus userStatus) {
        user.setStatus(userStatus);
        userDao.updateUser(user.getId(), user);
    }

    @Override
    public Message sendMessage(int userId, Message message) {
        IUserService userService = onlineUsers.get(userId);
        if(userService != null){
            userService.receiveMessage(message);
            return message;
        }else{
            System.out.println("User Not Found In Online Users");
        }
        return null;
    }

    @Override
    public List<Notification> getNotifications() {
        return null;
    }

    @Override
    public void register(int userId, IUserService userService) {
        onlineUsers.put(userId, userService);
    }

    @Override
    public void unRegister(int userId)
    {
        IUserService removedUser = onlineUsers.remove(userId);
        if(removedUser == null){ // Check User In Map
            System.out.println("Not Founed To Remove");
        }
    }

    @Override
    public void addFriend() {
    }

    @Override
    public void sendGroupMsg(User user, Message groupMessage) {

    }
}
