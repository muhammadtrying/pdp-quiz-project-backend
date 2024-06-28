package uz.muhammadtrying.pdpquizprojectbackend.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uz.muhammadtrying.pdpquizprojectbackend.entity.Module;
import uz.muhammadtrying.pdpquizprojectbackend.entity.enums.DifficultyEnum;
import uz.muhammadtrying.pdpquizprojectbackend.interfaces.ModuleService;
import uz.muhammadtrying.pdpquizprojectbackend.projections.ModuleProjection;
import uz.muhammadtrying.pdpquizprojectbackend.repo.ModuleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;

    @Override
    public void save(Module module) {
        moduleRepository.save(module);
    }

    @Override
    public List<ModuleProjection> findAllByCategoryId(Integer chosenCategoryId, String difficulty) {
        return sortModuleProjectionsByDifficulty(difficulty, moduleRepository.findAllByCategoryAndDifficulty(chosenCategoryId));
    }

    private static List<ModuleProjection> sortModuleProjectionsByDifficulty(String difficulty, List<ModuleProjection> moduleProjections) {
        return moduleProjections.stream()
                .filter(mp -> mp.getQuestionLists().stream()
                        .anyMatch(ql -> ql.getDifficulty().equals(DifficultyEnum.valueOf(difficulty)))).collect(Collectors.toList());
    }
}
