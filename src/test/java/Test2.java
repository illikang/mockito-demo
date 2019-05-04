import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import java.util.List;

public class Test2 {
    @Mock
    private List mockedList;
    @Mock
    private Person mockedPerson;

    //用注解的方法，需要重写构造方法，初始化类中的Mock成员变量，否则这些Mock对象都是Null的
    public Test2(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test(){
        //如果没有设置Mock对象的行为而直接调用其方法，则方法返回null
//        when(mockedPerson.getGender()).thenReturn("male");
        System.out.println(mockedPerson.getGender());

    }

    @Test
    public void behavior_test(){
        mockedList.add(1);
        verify(mockedList).add(1);
        mockedPerson.getAge();
        verify(mockedPerson).getAge();
        verify(mockedList,times(1)).add(1);
    }
}
