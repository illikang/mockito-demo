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
        //����Mockito��ľ�̬����mock()����Mock����
        Assert.assertTrue(mockedList instanceof List);

        //��������mock����Ľӿ��࣬������mock�������
        ArrayList mockedArryalist= mock(ArrayList.class);
        Assert.assertTrue(mockedArryalist instanceof List);
        Assert.assertTrue(mockedArryalist instanceof ArrayList);

        //������mock�����Ժ󣬿��Զ������ľ�����Ϊ������ģ��������ʵ��Ҫ����
        //ʹ��when()..thenReturn()������������һ����Ϊ�����Ƶ�����mockedList.add("one")ʱ������true
        when(mockedList.add("one")).thenReturn(true);
        //������mockedList.size()ʱ������1
        when(mockedList.size()).thenReturn(1);
        //��Ϊû�ж���mockedList.add("two"),��˷���Ĭ��ֵfalse
        //Ҳ����˵������mock�����κ�û���ƶ�����Ϊ�����᷵��false
        Assert.assertTrue(mockedList.add("one"));
        Assert.assertEquals(mockedList.size(),1);
//        Assert.assertTrue(mockedList.add("two"));
    }

    @Test
    public void test2(){
        //��һ�ε���iterator.next()���ء�Hello��,�Ժ��ٵ��ö����ء�Leon��
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
