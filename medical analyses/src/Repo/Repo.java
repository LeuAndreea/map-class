package Repo;

import java.util.*;

public class Repo {
    protected Vector objects;

    public Repo() {
        this.objects = new Vector();

    }

    public int getSize(){
        return this.objects.size();
    }

    public Vector getObjects() {
        return objects;
    }

    public Object getObject(Object o){
        return this.getObjectByIndex(this.findObject(o));
    }

    public Object getObjectByIndex(int i){
        if (i!=-1)
            return this.objects.elementAt(i);
        else
            return null;
    }

    /*Searches for the existence of an object.
    IN: object
    OUT: true if object is already there, false if it is not.
     */
    public int findObject(Object o) {
        for (int i=0; i<this.objects.size(); i++)
            if (o.equals(this.objects.elementAt(i)))
                return i;
        return -1;
    }

    /*Adds a new object to the repository
    /In: object
    /Out: 1 if the object was successfully added, -1 if not.
    */
    public int addObject(Object o)
    {
        if (this.findObject(o)==-1) {
            this.objects.add(o);
            this.writeToFile();
            return 1;
        }
        return -1;

    }

    /*Deletes an object from the vector.
    In:an object
    out: 1 if object successfully deleted or -1 if
     */
    public int deleteObject(Object o){
        if (this.findObject(o)!= -1) {
            this.objects.remove(o);
            this.writeToFile();
            return 1;
        }
        return -1;
    }

    public void writeToFile(){}
}