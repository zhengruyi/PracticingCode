<script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=default"></script>

###关键参数计算
#### 1.计算bit数组长度m的公式为
`m = -1 *(n*lnP)/(ln2)^2 `

其中 P表示可以接受的误判率，n表示需要筛选的数据总量

####2.计算哈希函数个数k的计算方法
`k = ln2 * m /n = 0.7 * m /n`

其中m表示bit 数组长度,n表示数据总量

####3.布隆过滤器的真实误判率p计算公式
`p = (1 - e^(-1 * n*k /m))^k`

其中 n表示数据总量,m表示bit数组长度，k表示哈希函数的个数

### 推导过程

1.当一个对象被k个哈希函数计算后总共要k次涂黑长度为m数组
则一个位置仍然没有被涂黑的概率`（1-1/m)^k`，经过n个对象后
仍然没有被涂黑的概率`（1-1/m)^(k*n)`反之被涂黑的概率`1-（1-1/m)^(k*n)`

2.那么在检查阶段k个位置都为黑的概率

`(1-(1-1/m)^(k*n))^k = (1-(1-1/m)^(-m *(-1*k*n/m))^k`

当x趋近于0时候 `(1+x)^(1/x)  -> e`
所以`(1-(1-1/m)^(-m *(-1*k*n/m))^k -> (1-e^(-1*n*k/m))^k`
