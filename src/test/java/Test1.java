import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.mockito.Mockito.*;

public class Test1 {

    List realList=new ArrayList();

    //    List mockedList=mock(List.class);
    @Mock
    private List mockedList;



    Iterator iterator=mock(Iterator.class);

    @Test
    public void test1(){
        //调用Mockito类的静态方法mock()创建Mock对象
        Assert.assertTrue(mockedList instanceof List);

        //不仅可以mock具体的接口类，还可以mock具体的类
        ArrayList mockedArryalist= mock(ArrayList.class);
        Assert.assertTrue(mockedArryalist instanceof List);
        Assert.assertTrue(mockedArryalist instanceof ArrayList);

        //创建了mock对象以后，可以定制它的具体行为，用于模仿我们真实需要的类
        //使用when()..thenReturn()方法链来定义一个行为，定制当调用mockedList.add("one")时，返回true
        when(mockedList.add("one")).thenReturn(true);
        //当调用mockedList.size()时，返回1
        when(mockedList.size()).thenReturn(1);
        //因为没有定义mockedList.add("two"),因此返回默认值false
        //也就是说，对于mock对象，任何没有制定的行为，都会返回false
        Assert.assertTrue(mockedList.add("one"));
        Assert.assertEquals(mockedList.size(),1);
//        Assert.assertTrue(mockedList.add("two"));
    }

    @Test
    public void test2(){
        //第一次调用iterator.next()返回“Hello”,以后再调用都返回“Leon”
        when(iterator.next()).thenReturn("Hello").thenReturn("Leon");
        String str=iterator.next()+" "+iterator.next()+" "+iterator.next();
        String str1=iterator.next()+" ";
        System.out.println(str);
        System.out.println(str1);
    }

    @Test(expected = NoSuchElementException.class)
    public void test3(){
        when(iterator.next()).thenReturn("First time");
        doThrow(new NoSuchElementException()).when(iterator).next();
        iterator.next();
        iterator.next();
    }
    @Test
    public void test4(){
        mockedList.add("one");
        mockedList.add("two");
        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");
        when(mockedList.size()).thenReturn(5);
        Assert.assertEquals(mockedList.size(),5);

        verify(mockedList,atLeastOnce()).add("one");
        verify(mockedList,times(1)).add("two");
        verify(mockedList,times(3)).add("three times");
        verify(mockedList,never()).isEmpty();

    }
}
