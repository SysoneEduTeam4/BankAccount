### Lombok ?

?�����ڰ� �ۼ��ؾ��ϴ� �ڵ带 ��������ִ� �پ��� �������̼��� �����ϴ� �ڹ� ���̺귯��

? �������� ������̼��� �����ϰ� �̸� ������� �ڵ带 �����ϰ������� �������ִ� ������� �����ϴ� ���̺귯�� 

### ����

? �������� ���δ�

? �ڵ� ���꼺�� ���δ� 

### ����

? �������� ���ܹ����� �߻��� �� �ִ� 

### ����

| Annotation | ���� |
| --- | --- |
| @Getter | �ش� ������̼��� �����ϸ� �ڵ����� getXXX() �޼��带 ��� �����ϰ� ���ݴϴ�. |
| @Setter | �ش� ������̼��� �����ϸ� �ڵ����� setXXX() �޼��带 ��� �����ϰ� ���ݴϴ�. |
| @Data | �ش� ������̼��� �����ϸ� getter(), setter(), equals(), hasCode(), toString() �޼��� ��� �����ϰ� ���ݴϴ�.(@Getter @Setter @toString @EqaulsAndHashCode @RequiredArgsConstructor�� �ڵ� �������ݴϴ�. |
| @ToString | �ش� ������̼��� �����ϸ� toString() �޼��带 ��� �����ϰ� ���ݴϴ�. |
| @AllArgsConstructor | �ش� ������̼��� �����ϸ� ����硯 ���ڸ� ������ �����ڸ� �����մϴ�. |
| @RequriedArgsConstructor | �ش� ������̼��� �����ϸ� ���ʼ��� ������ ������ �����ڸ� �����մϴ�. |
| @NoArgsConstructor | �ش� ������̼��� �����ϸ� �����ڰ� ���¡� �����ڸ� �����մϴ�. |

### ��� ���

```java
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
```

������ ������̼� @Data 

�� @Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor �� �ڵ��ϼ�