class Solution {
    fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {
        val limit = video_len.split(":").run{
            formatTime(this[0], this[1])
        }
        var now = pos.split(":").run{
            formatTime(this[0], this[1])
        }
        val opStart = op_start.split(":").run{
            formatTime(this[0], this[1])
        }
        val opEnd = op_end.split(":").run{
            formatTime(this[0], this[1])
        }
        
        commands.forEach{
            if(now >= opStart && now < opEnd){
                now = opEnd
            }
            
            when(it){
                "next" -> {                    
                    now += 10
                    if(now > limit){
                        now = limit
                    }
                }
                
                "prev" -> {
                    now -= 10
                    if(now < 0){
                        now = 0
                    }
                }
                
                else -> Unit
            }
        }
        
        if(now >= opStart && now < opEnd){
                now = opEnd
        }
        
        val m = now / 60
        val s = now % 60
        
        return String.format("%02d:%02d", m, s)
    }
    
    fun formatTime(s1:String, s2: String) : Int{
        return s1.toInt() * 60 + s2.toInt()
    }
}

