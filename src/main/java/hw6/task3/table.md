|                                                   | Correct    |Not correct  |Description                                      |
| -------------------------------------------------:|:----------:|:-----------:|:-----------------------------------------------:|
|Doctor doctor1 = new Doctor();                     |      [x]   |      [ ]    |Тип ссылки и тип объекта одинаковы               |
|Doctor doctor2 = new MedicalStaff();               |      [ ]   |      [x]    |Downcasting не разрешен здесь                    |
|Doctor doctor3 = new HeadDoctor();                 |      [x]   |      [ ]    |Upcasting, ссылка указывает на родительский тип  |
|Object object1 = new HeadDoctor();                 |      [x]   |      [ ]    |Upcasting, все классы наследуются от Object      |
|HeadDoctor doctor5 = new Object();                 |      [ ]   |      [x]    |Upcasting                                        |
|Doctor doctor6 = new Nurse();                      |      [ ]   |      [x]    |Оба класса являются потомками одного родителя    |
|Nurse nurse = new Doctor();                        |      [ ]   |      [x]    |Оба класса являются потомками одного родителя    |
|Object object2 = new Nurse();                      |      [x]   |      [ ]    |Upcasting, все классы наследуются от Object      |
|List<Doctor> list1= new ArrayList<Doctor>();       |      [x]   |      [ ]    |Тип ссылки и тип объекта одинаковы               |
|List<MedicalStaff> list2 = new ArrayList<Doctor>();|      [ ]   |      [x]    |В generics тип ссылки и тип объекта должны совпадать|
|List<Doctor> list3 = new ArrayList<MedicalStaff>();|      [ ]   |      [x]    |В generics тип ссылки и тип объекта должны совпадать|
|List<Object> list4 = new ArrayList<Doctor>();      |      [ ]   |      [x]    |В generics тип ссылки и тип объекта должны совпадать, игнорируются отношения предок-наследник|
|List<Object> list5 = new ArrayList<Object>();      |      [x]   |      [ ]    |Тип ссылки и тип объекта одинаковы               |