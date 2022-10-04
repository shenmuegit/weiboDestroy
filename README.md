# 微博删除工具
- 循环次数取决于微博数量(1页20)
- 需要更改代码中header中的Cookie，
  - 获取Cookie方法
      1. 打开浏览器版微博并登陆
      2. 右键检查(火狐,chrome)
      3. 找到url为 https://weibo.com/ajax/statuses/mymblog 的请求
      4. 在请求头中找到Cookie
