public class RogueThread implements Runnable {


    public void run() {

        Util oUtil = new Util();
        MerkleManager merkleManager = new MerkleManager();

        while(true){

            oUtil.sleepRandomTime("Rogue Thread");
            String sNewWord = merkleManager.grabWord();

            if(sNewWord != null){
                System.out.println("[Rogue] grabbed a word >>> STRIKE!");
                MerkleManager.iStrike++;
            }
        }
    }
}