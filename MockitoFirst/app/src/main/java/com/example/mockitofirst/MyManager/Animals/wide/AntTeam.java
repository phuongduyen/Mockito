package com.example.mockitofirst.MyManager.Animals.wide;

import android.os.UserManager;
import android.text.TextUtils;

import com.example.mockitofirst.Enemy;
import com.example.mockitofirst.MyManager.Animals.Animal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.List;

class AntTeam extends Animal {
    int countTeam;
    String local;
    Enemy enemy;

    public AntTeam() {
        enemy.createInstance();
    }

    public AntTeam(int countTeam, String local, Enemy enemy) {
        this.countTeam = countTeam;
        this.local = local;
        this.enemy = enemy;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public int getCountTeam() {
        return countTeam;
    }

    public void setCountTeam(int countTeam) {
        this.countTeam = countTeam;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }


//    khai bao binh thuong: tac vu binh thuong -> junit
//
//    mock: phai set when, neu k se k co action (real method ) nao tra ve -> result null
//    mock k the lam thay doi gia tri cua bien, chi co the gia lap ket qua tra ve thong qua when()
//
//    @Spy: co lam thay doi gia tri khi action, cung co the gia lap ket qua
//    Spy là việc sửa một đối tượng Thật -> Giả
//    Trong trường hợp bạn sử dụng annotation Mock để tạo instance của 1 class nhưng trong class đó có vài hàm bạn muốn chạy thực thay vì phải định nghĩa trước giá trị trả về. Đây chính lúc bạn cần @Spy. @Spy còn được mô tả như partial mock: bạn có thể hiểu như là object giả 1 phần. Đối với các hàm không được quy định trước hành vi hoặc giá trị trả về sẽ được gọi thực. (Bạn có thể tham khảo thêm ở link này để hiểu hơn ví dụ của partial mock + hoàn cảnh sử dụng @Spy)
//    Chính vì nửa thực nửa giả nên spy object cũng khai báo khác với @Mock object!
//
//    @Spy
//    private DetailViewModel mDetailViewModel = new DetailViewModel(mMovieRepository);
//
//    @InjectMocks
//    tạo một thể hiện của lớp và đưa các mock  được tạo ra với các chú thích @Mock(hoặc @Spy) vào thể hiện này.
//    @Mock creates a mock. @InjectMocks creates an instance of the class and injects the mocks that are created with the @Mock (or @Spy) annotations into this instance.
//    Lưu ý rằng bạn thậm chí không phải tạo một new InjectMocks đối tượng. Mockito sẽ tiêm nó cho bạn.
//    cas mock tu dong inject vao injectMock
//
//# Captor
//    Captor có nhiệm vụ ghi lại các tham số của đối tượng
//
//    @RunWith(MockitoJUnitRunner.class)
//    public class CaptorTest {
//        @Mock
//        List<Object> list;
//
//        @Captor
//        ArgumentCaptor<Object> captor;
//
//        @Test
//        public void testCaptor1() {
//            list.add(1);
//            // Capture lần gọi add vừa rồi có giá trị là gì
//            Mockito.verify(list).add(captor.capture());
//
//            System.out.println(captor.getAllValues());
//
//            Assert.assertEquals(1, captor.getValue());
//        }
//    }
//
//
//
//    Matcher cũng như regex hay các đại diện cho đầu vào hoặc đầu ra thay vì bạn chỉ định nó là 1 giá trị cụ thể
//    any()
//    Thay cho mọi object kể cả null:
//    when(TextUtils.isEmpty(any()).thenReturn(false); Khi hàm TextUtils.isEmpty(value) được gọi dù value có mang giá trị gì thì kết quả trả về luôn luôn là false.
//    any(ClassName.class)
//    Nó chỉ định giá trị cụ thể hơn cho any(), chỉ chấp nhận các object của ClassName:
//            Mockito.verify(mDetailViewModel, times(0)).setMovie(any(MovieResponse.class));
//    anyInt(), anyBoolean(), anyByte(), anyFloat(), anyList() ....
//    Các hàm này sẽ thay thế cho các giá trị tương ứng.
//    Để khắc phục nó bạn có 2 cách:
//    C1: Sử dụng Matcher cho cả 2:
//    when(spyObject.concatenateString(anyString(), anyString())).thenReturn("hello world!");
//
//    C2: sử dụng hàm eq() như 1 Argument Matcher bao bọc giá trị của bạn!:
//    when(argMatcher.concatenateString(anyString(), eq("world"))).thenReturn("hello world!");
//
//    PowerMock
//    PowerMock cho phép chúng ta mock các static, private, constructors, final class ... nhờ vào việc xây dựng 1 custom class loader riêng và chuyển đổi byte code. Chính vì vậy mình đã sử dụng PowerMock để mock các static method ở trên.
//    PowerMock với Static method
//    Thêm annotation @PrepareForTest(ClassName): bạn cần list các class chứa các static method cần được mock (như trong ví dụ bên trên). Bạn có thể thêm trước tên class hoặc trước hàm test.
//    Sử dụng mockStatic(ClassName) đầu tiên trong mỗi hàm test.
//    Khi stub static method: when(ClassName.methodName()).thenReturn(returnValue);
//    Ví dụ như: when(UserManager.getInstance()).thenReturn(mUserManager)
//    Khi bạn cần xác nhận tương tác với 1 static method: verifyStatic(ClassName.class, times(1))
//
//
//    PowerMock với Private method
//    Static và private đều cần thêm @PrepareForTest(ClassName) để yêu cần PowerMock chuẩn bị các class này trước khi test. Đây cũng là các class cần được chuyển sang bytecode khi test.
//    Để stub trên private method :
//    when(mockObject, "privateMethodName").thenReturn(value);
//    Để xác minh tương tác:
//    verifyPrivate(mockedObject).invoke(“privateMethodName”)
//
//    org.mockito.Mock constructor
//
//    Để mock một constructor, chúng ta sử dụng cấu trúc sau:
//            PowerMockito.whenNew(classWillBeConstructored).withNoArguments().thenReturn(object);
//
//PowerMockito.whenNew(classWillBeConstructored).withAnyArguments().thenReturn(object);
//
//PowerMockito.whenNew(classWillBeConstructored).withArguments(firstArgument, additionalArguments).thenReturn(object);
//
//    https://gpcoder.com/5447-gioi-thieu-powermock/

}
