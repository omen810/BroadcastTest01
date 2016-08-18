# 《第一行代码》5.2.1 动态注册监听网络变化

## 学习BroadcastReceiver

### 分支1：1_catch_network_change

动态注册监听网络变化

### 分支2：2_network_on_or_off

识别网络开启或关闭

### 分支3：3_boot_complete_receiver 

静态注册实现开机启动

### 分支4：4_normal_broadcast 

自定义广播之标准广播

### 分支5：5_ordered_broadcast 

发送有序广播，本身与BroadcastTest02一起接收广播，通过优先级截断后，BroadcastTest02无法再继续接收

