package thread.base;

import java.time.LocalDateTime;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Order {

    public static OrderRecord orderRecord;

    public static void main(String[] args) {
        // 1.接单 25分钟提醒
        accessOrder("吴先生", "深圳市龙华区民治街道慧鑫公寓E栋", "13632764567", 5);
    }

    private static void accessOrder(String user, String address, String phone, double kiloMeter) {
        // 1.生成订单
        String driver = "刘师傅";
        orderRecord = createOrder(user, address, phone, kiloMeter, driver);
        System.out.println(LocalDateTime.now().toString() + "已接单,用户：" + user + "，手机号：" + phone + "，地址：" + address + "，距离：" + kiloMeter + "km");
        // 2.生成催单定时回调（5分钟）"
        double minutes = getMinutes(kiloMeter);
        remindMessage(orderRecord, minutes);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 2.到达目的地
        arrive(orderRecord);
    }

    private static OrderRecord createOrder(String user, String address, String phone, double kiloMeter, String driver) {
        OrderRecord orderRecord = new OrderRecord();
        orderRecord.setOrderId(phone + System.currentTimeMillis());
        orderRecord.setAddress(address);
        orderRecord.setUser(user);
        orderRecord.setPhone(phone);
        orderRecord.setKilMeter(kiloMeter);
        orderRecord.setDriver(driver);
        orderRecord.setStatus(1);
        return orderRecord;
    }

    // 到达目的地
    private static void arrive(OrderRecord orderRecord) {
        System.out.println("用户【" + orderRecord.getUser() + "】到达目的地，修改为已到达");
        orderRecord.setStatus(2);
    }

    // 回调任务，几分钟后如果司机未到一定阶段则提醒司机
    private static void remindMessage(OrderRecord orderRecord, double minutes) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.schedule(() -> {
            if (orderRecord.getStatus() != 2) {
                System.out.println("订单" + orderRecord.OrderId + "即将超时,请注意");
            }
        }, (int) minutes, TimeUnit.SECONDS);
    }

    public static class OrderRecord {

        private String OrderId;

        private String user;

        private String address;

        private String phone;

        private double kilMeter;

        private String driver;

        // 状态 1 已接单 2 已到达
        private int status;

        public String getOrderId() {
            return OrderId;
        }

        public void setOrderId(String orderId) {
            OrderId = orderId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public double getKilMeter() {
            return kilMeter;
        }

        public void setKilMeter(double kilMeter) {
            this.kilMeter = kilMeter;
        }

        public String getDriver() {
            return driver;
        }

        public void setDriver(String driver) {
            this.driver = driver;
        }
    }


    // 根据里程获取需要提醒分钟数
    private static double getMinutes(double kiloMeter) {
        return kiloMeter;
    }
}
