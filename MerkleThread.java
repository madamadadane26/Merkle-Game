import java.util.ArrayList;

public class MerkleThread implements Runnable {

    public static volatile ArrayList<String> grabbedWords;
    private int iMerkleTreeInputs = 4;


    public void run(){

        Util oUtil = new Util();
        MerkleManager merkleManager = new MerkleManager();

        grabbedWords = new ArrayList<>();

        while(true){

            oUtil.sleepRandomTime("Merkle Thread");
            String sNewWord = merkleManager.grabWord();


            if(sNewWord != null){
                oUtil.print("[Merkle] grabbed a word");
                grabbedWords.add(sNewWord);
                if(grabbedWords.size() == iMerkleTreeInputs){

                    MerkleManager.sMerkleRoot = oUtil.getMerkleRoot(grabbedWords);
                }
            }
        }
    }


}
