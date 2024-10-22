import { Button } from "@/components/ui/button"
import ElevatedInput from "@/components/elevated-input"
import UserStatsCard from "./components/user-stats-card"
 
export default function Home() {
  return (
    <div className="flex items-center justify-center min-h-screen">
      <div className="flex flex-col items-center gap-4">
        <ElevatedInput/>
        <UserStatsCard/>
        <UserStatsCard/>
      </div>
    </div>
  )
}
