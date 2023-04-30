svnadmin create repo
cd repo
svn mkdir -m "create structure" file:///home/kyoto/git/repo/trunk
svn checkout file:///home/kyoto/git/repo/trunk workspace
cd workspace
 
# r0
cp -R ~/git/src ./
svn add *
svn commit -m "working" --username="govno"
rm src/main/java/com/kyoto/alaba3/util/Result*
echo "adfsdfg" >> src/main/java/com/kyoto/alaba3/exception/WrongValueException.java 
svn add *
svn commit -m "not working" --username="mocha"
svn switch file:///home/kyoto/git/repo/trunk
svn log
