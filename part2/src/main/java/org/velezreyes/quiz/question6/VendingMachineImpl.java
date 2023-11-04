package org.velezreyes.quiz.question6;

public class VendingMachineImpl implements VendingMachine {

  private  float money;
  public static VendingMachine getInstance() {
    // Fix me!
    return new VendingMachineImpl();
  }

  @Override
  public void insertQuarter() {
    this.money += 0.25F;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    if(name.equals("ScottCola")) {
      if (this.money >= 0.75F) {
        this.money = 0;
        return new Drink() {
          @Override
          public String getName() {
            return "ScottCola";
          }

          @Override
          public boolean isFizzy() {
            return true;
          }
        };
      } else {
        throw new NotEnoughMoneyException();
      }
    } else if (name.equals("KarenTea")) {
      if (this.money >= 1.0F) {
        this.money = 0;
        return new Drink() {
          @Override
          public String getName() {
            return "KarenTea";
          }

          @Override
          public boolean isFizzy() {
            return false;
          }
        };
      } else {
        throw new NotEnoughMoneyException();
      }
    } else {
      throw new UnknownDrinkException();
    }

  }
}
