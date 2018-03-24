package edu.uade.appl_interact.model.dao;

import junit.framework.Assert;
import junit.framework.TestCase;

public final class UserTest extends TestCase {
  public void testGetters() {
    User user = new User();
    user.setName("qwerty");
    Assert.assertEquals("qwerty", user.getName());
  }
}