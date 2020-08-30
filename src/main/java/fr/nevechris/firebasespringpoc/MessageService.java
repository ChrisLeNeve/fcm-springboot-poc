package fr.nevechris.firebasespringpoc;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public void sendFirebaseMessage() {
        // This registration token is the token of the device you're sending the message to. It's obtained when a
        // device registers with Firebase. In an Android app, it's accessible as follows:
        // FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
        //      @Override
        //      public void onComplete(@NonNull Task<InstanceIdResult> task) {
        //          if (!task.isSuccessful()) {
        //              Log.w(TAG, "getInstanceId failed", task.getException());
        //              return;
        //          }
        //          String token = task.getResult().getToken();
        //      }
        //  });
        String registrationToken = "whatever-your-device-registration-token-is";

        // Data of your message. Key/value pairs accessible from an Android client as follows:
        // instanceOfRemoteData.getData().get("firstName")
        Message message = Message.builder()
                .putData("firstName", "James")
                .putData("lastName", "Bond")
                .setToken(registrationToken)
                .build();

        // Send the message with registration token and body to device.
        String response = null;
        try {
            response = FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            System.out.println("Error sending Firebase message: " + e.getMessage());
        }
    }
}
