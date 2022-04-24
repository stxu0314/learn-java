package vip.grmz.proxy;

/**
 * 静态代理举例
 * @Author STXU
 * @Date 2022/4/21 8:51
 * @Version 1.0
 */
interface ClothFactory{
    /**
     *
     */
    void produceCloth();
}
//代理类
class ProxyClothFactory implements ClothFactory {

    private ClothFactory factory; // 用被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }
    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");

        factory.produceCloth();

        System.out.println("代理工厂做一些收尾工作");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("nike工厂生产一批鞋");
    }
}
public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类的对象
        NikeClothFactory nike = new NikeClothFactory();
        //创建代理类的对象
        ProxyClothFactory proxy = new ProxyClothFactory(nike);

        proxy.produceCloth();

    }
}
