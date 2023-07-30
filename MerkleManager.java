import java.util.ArrayList;

public class MerkleManager {

    public static volatile String sUserEnteredWord;
    public static String sEnteredExpectedRt;
    public static String sMerkleRoot = null;
    public static int iStrike = 0;


    public void manageFunction() {
        Util oUtil = new Util();

        Thread oMerkleThread = new Thread(new MerkleThread());
        Thread oRogueThread = new Thread(new RogueThread());
        Thread oMonitorThread = new Thread(new MonitorThread());

        sEnteredExpectedRt = oUtil.promptUser("Please enter expected Merkle Root: ");

        oMerkleThread.start();
        oRogueThread.start();
        oMonitorThread.start();


        while(true){
            sUserEnteredWord = oUtil.promptUser("Please enter a word: ");
        }

    }

    public String grabWord(){
        String temp = sUserEnteredWord;
        sUserEnteredWord = null;
        return temp;
    }


}



/*
// Hashes
// Word1: ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb
// Word2: e44a31c328aeec4f34145bb6859b44507c095f4f80979456f7f5bad537ed9be5
// Word3: a851805fb1e09d9c1b5b6f622ba447523828bbf9c0cab1f12518261cd85d30ae
// Word4: b3250b0834e8a7b68412dfcd2ac333b4636ec4ee9ea42aebbfa88ad732a8aee9

H4: 29bf1dac16efc3d488e0bafc19aae11c1d711f60c00e804801716718fb7e2fe1
H5: 699bc41b124366b9b38893db75319f8e0f88465c3b33250bfeddddb551d96818
H6: 8f10528ea5dc045b15fd0aaf1eee45f24c0f6df46d0b1fc2bc355c0aa6c8c704

*/