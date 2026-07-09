class Solution {
    public boolean isBST(Node root) {
        // code here
        if(root==null) return true;
        ArrayList<Integer> res=new ArrayList<>();
        inorder(root,res);
        int size=res.size();
        for(int i=1;i<size;i++){
            if(res.get(i)<=res.get(i-1)){
                return false;
            }
        }
        return true;
        
    }
    public void inorder(Node root, ArrayList<Integer> res){
        if(root==null) return;
        inorder(root.left,res);
        res.add(root.data);
        inorder(root.right,res);
    }
}