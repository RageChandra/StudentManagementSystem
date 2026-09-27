public class Validation {
    static public boolean isValidName(String name){
        if(name==null){
            return false;
        }
        if(name.trim().isEmpty()){
            return false;
        }
        for(int i = 0 ; i<name.length() ; i++){
            char ch = name.charAt(i);
            if(Character.isDigit(ch)){
                return false;
            }
        if (!Character.isLetter(ch) && !Character.isWhitespace(ch)) {
                    return false;
            }
        }
        return true;
        
    }
    static public boolean isValidAge(int age){
        if(age>=16 && age<=30){
            return true;
        }
        else{
            return false;
        }

    }
    static public boolean isValidCgpa(double cgpa){
        if(cgpa>=0.0 && cgpa<=10.00){
            return true;
        }
        else{
            return false;
        }

    }
    static public boolean isValidBranch(String branch){
        if(branch==null){
            return false;
        }
        if(branch.equalsIgnoreCase("CSE" )||branch.equalsIgnoreCase("ECE" )||branch.equalsIgnoreCase("EEE" )||branch.equalsIgnoreCase("MECH" )||branch.equalsIgnoreCase("CIV" )||branch.equalsIgnoreCase("CSM")){
            return true;
        }
        else{
            return false;
        }

    }
    static public boolean isValidMobileNumber(String Mobile){
        if(Mobile==null){
            return false;
        }
        if(Mobile.length()==10){
            return true;
        }
        else{
            return false;
        }
    }
    static public boolean isValidLogin(int enteredAdmin_id , String EnteredAdmin_password){
        Admin a1 = new Admin();
        if(enteredAdmin_id==a1.getAdminId()&&EnteredAdmin_password.equals(a1.getPassword())){
            return true;
        }
        return false;
    }
}
