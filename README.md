# CoderClock
码农时钟
## 需求说明
“码农酒店”世界时钟产品特性
作为一位酒店大堂服务人员，我想在大堂的城市时钟不准时，用设置自己手机时间的方法，自动统一调整这些城市时钟时间，来避免逐一根据时差调整这些时钟的繁琐工作，系统特性具体包括：
1)	REQ1: ”码农酒店”大堂里有5个时钟，分别显示北京、伦敦、莫斯科、悉尼和纽约的时间
2)	REQ2: 伦敦与UTC时间一致，北京比UTC时间早8小时，莫斯科比UTC时间早4小时，悉尼比UTC时间早10小时，纽约比UTC时间晚5小时
3)	REQ3: 将酒店大堂服务员的智能手机时间设置为北京时间
4)	REQ4: 若大堂墙壁上所有城市的时钟都或多或少有些走时不准，需要调整时间时，只需调准服务员手机的时间，那么墙上5个城市的时钟时间都能够相应地自动调整准确
## 包的说明
1. clock包：存储clock所有类，clock为接口
2. constant包：存储时差常量
3. controller包：控制相关流程进行
4. util包：工具类，设置了timeParser将字符串时间转化为LocalDateTime对象
5. view包：与用户进行交互的界面窗口
## 测试说明
实现了以下测试并全部通过测试
1. 测试手机时间是否设置为北京时间
2. 测试每个钟时间时差是否正确
3. 测试util.TimeParser能否正常工作
4. 测试ClockController是否为单例模式
5. 测试调整手机时间是否正确
6. 测试调整手机时间后时钟的时间显示是否正确
## 设计理念
1. 大致采用了模型、视图
