import UIKit
import atter_logic

class ViewController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
        let events = GetEvents().invoke()
        label.text = events.first?.name
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    @IBOutlet weak var label: UILabel!
}
