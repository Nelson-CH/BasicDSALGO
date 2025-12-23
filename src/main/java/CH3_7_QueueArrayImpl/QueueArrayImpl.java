package CH3_7_QueueArrayImpl;

public class QueueArrayImpl {
    Integer[] ary;       // 用來初始化 queue 的資料來源
    Integer[] queue;     // 真正儲存 queue 元素的陣列

    Integer iFront = null; // front 指向下一個要被 poll 的位置；null 代表空佇列
    Integer iEnd = null;   // end 指向最後一個元素的位置；null 代表空佇列

    public QueueArrayImpl() {}

    public QueueArrayImpl(Integer[] ary){
        this.ary = ary;
    }

    //初始化 queue
    public void build_queue(){
        this.queue = new Integer[this.ary.length];
        for (int i = 0 ; i < ary.length; i++) {
            offer(ary[i]);
        }
    }

    //添加元素
    private void offer(Integer val) {
        int s = size();

        // queue 已滿：擴容（容量 * 2）
        if (s == queue.length) {
            expand_space();
            s = size(); // 擴容後 size 仍不變，但可以保守刷新一次
        }

        // 空佇列：初始化 front/end
        if (s == 0) {
            iFront = 0;
            iEnd = 0;
            queue[iEnd] = val;
        } else {
            // 非空：end 往前移動（環形）
            iEnd = (iEnd + 1) % queue.length;
            queue[iEnd] = val;
        }
    }

    /**
     * 擴容：
     * 建立新陣列（容量 * 2），並把舊資料依 FIFO 順序搬過去
     * 你這裡用 poll() 搬運，確保順序正確，但會改動舊 queue 狀態（副作用）
     */
    private void expand_space() {
        //擴充大小的新陣列
        Integer[] queue_new = new Integer[this.queue.length * 2];

        int i = 0;
        while (true) {
            if (size() == 0) break;

            // poll() 會：
            // 1) 取出 front 的值
            // 2) front 往前移動（環形）
            // 3) 若只剩一筆會把 front/end 設為 null
            Integer val = poll();
            // 取出的值放進擴充大小後的新陣列
            queue_new[i] = val;
            i++;
        }

        // 搬完後，新 queue 的資料從 0 開始連續排列
        this.iFront = 0;
        this.iEnd = i - 1; //i是新 queue 的 length
        this.queue = queue_new;
    }

    /**
     * 計算 queue 目前元素數量
     * - 空：front/end 都是 null
     * - end >= front：沒有繞回
     * - end < front：已經繞回（環形）
     * front 指向下一個要被 poll 的位置
     * end 指向最後一個元素的位置
     */
    private int size() {

        if (iFront == null && iEnd == null) {
            //queue是空的
            return 0;
        } else if (iEnd >= iFront) {
            //一般陣列情境, iFront 是從 0 開始算所以補上 1
            return (iEnd - iFront) + 1;
        } else {
            //end < front, 環狀情境
            //queue.length - iFront: 算出前半段大小
            return (queue.length - iFront) + iEnd + 1;
        }

    }

    /**
     * poll：從隊首取出元素
     * - 空：回傳 null
     * - 只剩一筆：取出後設為空（front/end = null）
     * - 其他：front 往前走（環形）
     * front 指向下一個要被 poll 的位置
     * end 指向最後一個元素的位置
     */
    public Integer poll() {
        int s = size();
        if (s == 0) {
            return null;
        }

        Integer val = queue[iFront];
        queue[iFront] = null; // 釋放位置（可讓 GC 回收）

        if (s == 1) {
            iFront = null;
            iEnd = null;
        } else {
            iFront = (iFront + 1) % queue.length;
        }
        return val;
    }

    public static void main(String[] args) {
        Integer[] ary = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        QueueArrayImpl qa = new QueueArrayImpl(ary);
        qa.build_queue();
        qa.offer(6);

        System.out.println(qa.poll());
        System.out.println(qa.poll());
        System.out.println(qa.poll());

    }
}
