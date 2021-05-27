package com.readysoft.personalwallet.utilities.observer;

import com.readysoft.personalwallet.model.CustomUserDetail;
import com.readysoft.personalwallet.model.Payment;
import com.readysoft.personalwallet.model.User;

import java.util.List;

public interface Subject {
    void attach(User userObserver);
    void detach(User userObserver);
    void notifyUpdate();
}
