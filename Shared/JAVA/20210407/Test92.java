class Car {

	int gasolineGauge; 
	public Car(int gasolineGauge){
		this.gasolineGauge=gasolineGauge;
	}
}


class HybridCar extends Car {

	int electricGauge;
public HybridCar(int gasolineGauge,int electricGauge){
		super(gasolineGauge);
		this.electricGauge= electricGauge;
	}
}


class HybridWaterCar extends HybridCar {
	int waterGauge; 
	public HybridWaterCar(int gasolineGauge, int electricGauge, int waterGauge) {
		super(gasolineGauge,electricGauge);
		this.waterGauge=waterGauge;
	}
	public void showCurrentGauge() {
		System.out.println("잔여 가솔린량 : " + gasolineGauge);
		System.out.println("잔여 전기량 : " + electricGauge);
		System.out.println("잔여 워터량 : " + waterGauge);

	}

}

public class Test92 {
	public static void main(String[] args) {
		HybridWaterCar hybridWaterCar1 = new HybridWaterCar(4, 2, 3);
		System.out.println("하이브리드 워터카1");
				hybridWaterCar1.showCurrentGauge();
		
		System.out.println("----------------");
		System.out.println("하이브리드 워터카2");
		HybridWaterCar hybridWaterCar2 = new HybridWaterCar(9, 5, 7);
		hybridWaterCar2.showCurrentGauge();

	}
}

