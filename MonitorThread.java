public class MonitorThread implements Runnable {



    public void run() {

        Util oUtil = new Util();

        while(true){
            if(MerkleManager.sMerkleRoot != null){
                if(MerkleManager.sMerkleRoot.equals(MerkleManager.sEnteredExpectedRt)){
                    oUtil.print("You Win: " +MerkleManager.sMerkleRoot);
                    System.exit(0);
                }
                else {
                    oUtil.print("The roots did not match: You lose!\n");
                    System.exit(0);
                }
            }
            else if(MerkleManager.iStrike == 3){
                oUtil.print("3 Strikes: you lost!");
                System.exit(0);
            }

            oUtil.sleep(1);
        }
    }
}
