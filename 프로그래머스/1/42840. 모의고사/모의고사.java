import java.util.*;

class Solution {
    class Person{
        int num;
        int score;
        Person(int num, int score){
            this.num = num;
            this.score = score;
        }
    }
    
    public ArrayList<Integer> solution(int[] answers) {
        int[] first = {1,2,3,4,5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third =  {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        Person person1 = new Person(1, 0);
        Person person2 = new Person(2, 0);
        Person person3 = new Person(3, 0);
        
        for(int i = 0 ; i < answers.length; i++){
            int d = answers[i];
            int answer1 = first[i % first.length] ;
            int answer2 = second[i % second.length] ;
            int answer3 = third[i % third.length] ;
            
            if(answer1 == d){
                person1 = new Person(1, person1.score + 1);
            } 
            
            if(answer2 == d){
                person2 = new Person(2, person2.score + 1);
            } 
            
            if(answer3 == d) {
                person3 = new Person(3, person3.score + 1);
            }
        }
        
        ArrayList<Person> list = new ArrayList();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        
        list.sort((o1, o2) -> {
            if(o1.score == o2.score){
                return o1.num - o2.num;
            }
            return o2.score - o1.score;
        });

        ArrayList<Integer> answer = new ArrayList();
        int max = list.get(0).score;
        System.out.println(max);
        for(Person person : list){
            if(max == person.score){
                answer.add(person.num);
                continue;
            }
            
            if(max > person.score){
                break;
            }
        }

        return answer;
    }
}