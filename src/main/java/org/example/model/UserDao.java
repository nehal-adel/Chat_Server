package org.example.model;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUser(int id);

    boolean updateUser(int id, User user);

    boolean deleteUser(int id);

    boolean addUser(User user);

    List<User> getFriendList(User user);

    ObservableList<PieChart.Data> getUsersByGender();

    ObservableList<PieChart.Data> getUsersByCountry();

    ObservableList<PieChart.Data> getUsersByStatus();


}
