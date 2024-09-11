class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int VIDEO_LEN = toInt(video_len), POS = toInt(pos), OP_START = toInt(op_start), OP_END = toInt(op_end);
        
        for(String command : commands) {
            
            if(OP_START <= POS && POS <= OP_END) POS = OP_END;
            if(command.equals("next")) {
                POS += 10;
                if(POS - VIDEO_LEN > 0) POS = VIDEO_LEN;
            }else if(command.equals("prev")) {
                POS -= 10;
                if(POS < 0) POS = 0;
            }
        }

        if(OP_START <= POS && POS <= OP_END) POS = OP_END;
        return toString(POS);
    }
    
    private int toInt(String time) {
        String[] splited = time.split(":");
        
        return Integer.parseInt(splited[0]) * 60 + Integer.parseInt(splited[1]);
    }
    
    private String toString(int time) {
        return ((time / 60 <= 9) ? "0" : "") + (time / 60) + ":" + ((time % 60 <= 9) ? "0" : "") + (time % 60);
    }
}