
设计模式:<br>
1.代理模式<br/>
    分类
    <ol>
        <li>静态代理</li>
        <p>需要目标类和代理类同时实现同一个接口,然后是对于目标类的一个扩容,因为代理类里面有目标类的引用</p>
        <li>jdk代理</li>
        <p>需要目标类和代理类同时实现同一个接口,然后通过jdk的动态代理, 生成一个类, 这一个缺点是代理类不需要和目标类实现同一个接口</p>
        <li>cglib代理</li>
        <p>这个更叫屌啦.<b>不需要</b>代理类和目标类实现同一个接口,因为采用的是子类的方式进行扩容,所有目标类不能有final修饰,否则无法生成子类, 而且方法不能用static/final修改.</p>
    </ol>








