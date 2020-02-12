package org.example.Controller;

import org.example.Interfaces.IChatService;
import org.example.model.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChatService extends UnicastRemoteObject implements IChatService {
    static List<User> onlineUsers = new ArrayList<>();
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
    public Message sendMessage(User user) {
        return null;
    }

    @Override
    public List<Notification> getNotifications() {
        return null;
    }

    @Override
    public void register(User user) {
        this.user = user;
        onlineUsers.add(this.user);
    }

    @Override
    public void unRegister(User user) {
        onlineUsers.remove(user);
    }

    @Override
    public void addFriend() {

    }

    @Override
    public void sendGroupMsg(User user, Message groupMessage) {

    }
}
