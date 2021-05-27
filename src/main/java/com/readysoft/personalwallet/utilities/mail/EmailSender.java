package com.readysoft.personalwallet.utilities.mail;

import com.readysoft.personalwallet.model.Payment;
import com.readysoft.personalwallet.model.User;

public interface EmailSender {
    void send(User user, Payment payment);
}
