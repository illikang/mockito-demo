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

    //��ע��ķ�������Ҫ��д���췽������ʼ�����е�Mock��Ա������������ЩMock������Null��
    public Test2(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test(){
        //���û������Mock�������Ϊ��ֱ�ӵ����䷽�����򷽷�����null
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
