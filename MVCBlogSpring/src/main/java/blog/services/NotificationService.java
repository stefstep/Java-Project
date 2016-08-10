package blog.services;

/**
 * Created by Hristo on 05.08.2016 г..
 */
public interface NotificationService {
    void addInfoMessage(String msg);
    void addErrorMessage(String msg);
}
