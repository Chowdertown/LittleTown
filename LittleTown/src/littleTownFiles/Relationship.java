package littleTownFiles;

public interface Relationship {
    
  public boolean isEnemy(Townie A, Townie B);
  public boolean hasCrush(Townie A, Townie B);
  public boolean hates(Townie A, Townie B);
  public boolean likes(Townie A, Townie B); 
  public boolean isAquaint(Townie A, Townie B);
  public boolean strangers(Townie A, Townie B);
  public boolean isInLove(Townie A, Townie B);
  public boolean isDating(Townie A, Townie B);
  public boolean isRelative(Townie A, Townie B);
  public boolean isSister(Townie A, Townie B);
  public boolean isBrother(Townie A, Townie B);
  public boolean isWife(Townie A, Townie B);
  public boolean isPet(Townie A, Townie B);
  public boolean isMom(Townie A, Townie B);
  public boolean isDad(Townie A, Townie B);
  public boolean isFriend(Townie A, Townie B);
  public int friendshipPoints(Townie A, Townie B);
  public int romancePoints(Townie A, Townie B);
}
