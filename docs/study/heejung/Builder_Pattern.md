## ���� ����

������ ���õ� ������ �������� , ������ ���μ����� ���� �پ��� ������ �ν��Ͻ��� ����� ���� ���� �� build �޼ҵ�� �ϳ��� �ν��Ͻ��� �����Ͽ� �����ϴ� ���� 

(�����ڸ� ������ ���� ������ִ� ����)

### ����

1. ��ü ���� ������ �ϰ��� ���μ����� ǥ�� 
2. ����Ʈ �Ű����� ������ ���������� ����
3. �ʼ� ����� ������ ����� �и� ����
4. ��ü ���� �ܰ踦 ������ �� ����
5. �ʱ�ȭ ������ ������� �и�
6. ����� ���� ���� ���ɼ� �ּ�ȭ�� �߱�

### ����

1. �ڵ� ���⼺ ����
2. ������ ���ٴ� ������ ��������
3. ����ģ ���� ������ ���� 

### ���� ���

- ���� Ŭ������ �����ϰ� , ������ ��ü�� �Ӽ��� ���� setter �޼��带 ����

```java
public class User {
    private String name;
    private int age;
    
    public static class Builder {
    //������ �Ķ���� ���� ���� 
        private String name; 
        private int age;
        
        public Builder withName(String name) {
            this.name = name;
            return this;
        }
        
        public Builder withAge(int age) {
            this.age = age;
            return this;
        }
        
        public User build() {
            User user = new User();
            user.name = this.name;
            user.age = this.age;
            return user;
        }
    }
    
    public static void main(String[] args) {
        User user = new User.Builder().withName("Henry").withAge(30).build();
    }
}
```